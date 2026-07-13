package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;
    private final String password = "donPAPA";

    @BeforeEach
    public void setUp() {
        diary = new Diary("Azeez", password);
    }

    @Test
    public void newDiaryIsLockedTest() {
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_diaryIsUnlockedTest() {
        diary.unlockDiary(password);
        assertFalse(diary.isLocked());
    }

    @Test
    public void unlockDiaryWithWrongPasswordThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> diary.unlockDiary("fake pass"));
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_lockDiary_diaryIsLockedTest() {
        diary.unlockDiary(password);
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_createEntry_numberOfEntriesIsOneTest() {
        diary.unlockDiary(password);
        diary.createEntry("life update", "I started programming");
        assertEquals(1, diary.getEntriesCount());
    }

    @Test
    public void createEntryTwice_numberOfEntriesIs2Test() {
        diary.unlockDiary(password);
        diary.createEntry("life update", "I started programming");
        diary.createEntry("Life Update", "am i loving it?");
        assertEquals(2, diary.getEntriesCount());
    }

    @Test
    public void diaryIsLocked_CreateEntry_ExceptionThrowTest() {
        assertTrue(diary.isLocked());
        assertThrows(IllegalArgumentException.class, () ->  diary.createEntry("life update", "I started programming"));
    }

    @Test
    public void diaryIsUnlocked_findEntryUsingId_returnsEntryTest() {
        String title = "life update";
        String content = "I started programming";

        diary.unlockDiary(password);
        int entryId =  diary.createEntry(title, content);
        Entry entry = diary.findEntryById(entryId);
        assertEquals(title, entry.getTitle());
        assertEquals(content, entry.getBody());
    }

    @Test
    public void diaryIsUnlocked_findEntryUsingId_ExceptionThrownTest() {
        diary.unlockDiary(password);
        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(7813)
        );
    }

    @Test
    public void diaryIsLocked_findEntryUsingId_ExceptionThrowntryTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("lifeeeee", "nawa oooo");
        diary.lockDiary();
        assertTrue(diary.isLocked());

        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(entryId));
    }

    @Test
    public void diaryIsUnlocked_CreateEntry_DeleteEntryById_NumberOfEntriesIs0Test() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("lifeeeee", "nawa oooo");
        assertEquals(1, diary.getEntriesCount());

        diary.deleteEntry(entryId);
        assertEquals(0, diary.getEntriesCount());
    }

    @Test
    public void diaryLocked_DeleteEntry_ExceptionThrowTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("lifeeeee", "nawa oooo");
        diary.lockDiary();
        assertTrue(diary.isLocked());

        assertThrows(IllegalArgumentException.class, () -> diary.deleteEntry(entryId));
    }

    @Test
    public void createEntry_updateEntry_changesAreVisibleTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("lifeeeee", "nawa oooo");
        diary.updateEntry(entryId, "new lifee", "new me");
        Entry entry = diary.findEntryById(entryId);
        assertEquals("new lifee", entry.getTitle());
        assertEquals("new me", entry.getBody());
    }

    @Test
    public void diaryIsLocked_UpdateEntry_throwsExceptionTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("lifeeeee", "nawa oooo");
        diary.lockDiary();
        assertTrue(diary.isLocked());

        assertThrows(IllegalArgumentException.class, () -> diary.updateEntry(entryId, "new life", "new me"));
    }
}