import unittest
from set import Set


class TestSet(unittest.TestCase):

    def test_set_is_empty(self):
        set = Set()
        self.assertTrue(set.is_empty())

    def test_set_is_not_empty(self):
        set = Set()
        set.add(1)
        self.assertFalse(set.is_empty())

    def test__set_add_more_than_one_item(self):
        set = Set()
        set.add(1)
        set.add(2)
        self.assertFalse(set.is_empty())
        self.assertEqual(set.get_set(), [1, 2])

    def test_set_wont_add_duplicate_item(self):
        set = Set()
        set.add(1)
        set.add(1)
        set.add(1)
        self.assertFalse(set.is_empty())
        self.assertEqual(set.get_set(), [1])
        self.assertEqual(set.get_size(), 1)

    def test_set_add_different_types_of_items(self):
        set = Set()
        set.add(1)
        set.add("string")
        set.add([1, 2, 3])
        self.assertFalse(set.is_empty())
        self.assertEqual(set.get_set(), [1, "string", [1, 2, 3]])
        self.assertEqual(set.get_size(), 3)

    def test_set_add_another_set(self):
        set = Set()
        set.add(1)
        set.add(2)
        item = [1, 2, 3, 4]
        set.add(item)
        set2 = Set()
        set2.add(3)
        set2.add(4)
        for items in set2.get_set():
            set.add(items)
        self.assertEqual(set.get_set(), [1, 2, [1,2,3,4], 3, 4])

    def test_set_remove_item(self):
        set = Set()
        set.add(1)
        set.add(2)
        set.add(3)
        set.remove(2)
        self.assertEqual(set.get_set(), [1, 3])

    def test_set_remove_item_not_in_set_throws_error(self):
        set = Set()
        set.add(1)
        set.add(2)
        with self.assertRaises(ValueError):
            set.remove(3)

    def test_set_clear(self):
        set = Set()
        set.add(1)
        set.add(2)
        set.clear()
        self.assertTrue(set.is_empty())






if __name__ == '__main__':
    unittest.main()