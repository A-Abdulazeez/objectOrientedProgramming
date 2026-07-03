import unittest 
from stack import Stack

class TestStack(unittest.TestCase):

    def test_stack_is_empty(self):
        stack = Stack()
        self.assertTrue(stack.is_empty())

    def test_stack_is_not_empty(self):
        stack = Stack()
        stack.add(1)
        self.assertFalse(stack.is_empty())

    def test_stack_take_more_items(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertFalse(stack.is_empty())

        self.assertEqual(stack.get_size(), 2)

    def test_stack_pop_item(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertFalse(stack.is_empty())
        stack.pop()
        self.assertEqual(stack.get_size(), 1)

    def test_pop_from_empty_stack_throws_error(self):
        stack = Stack()
        with self.assertRaises(IndexError):
            stack.pop()

    def test_stack_pop_returns_last_item(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertEqual(stack.pop(), 2)

    def test_stack_size_after_pop(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertFalse(stack.is_empty())
        stack.pop()
        self.assertEqual(stack.get_size(), 1)

    def test_peek_returns_last_item_without_removing(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertFalse(stack.is_empty())

        self.assertEqual(stack.peek(), 2)

    def test_peek_from_empty_stack_throws_error(self):
        stack = Stack()
        with self.assertRaises(IndexError):
            stack.peek()

    def test_stack_size_after_peek(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        self.assertFalse(stack.is_empty())
        stack.peek()
        self.assertEqual(stack.size, 2)

    def test_get_stack_returns_all_items(self):
        stack = Stack()
        stack.add(1)
        stack.add(2)
        stack.add(3)
        stack.add(4)
        stack.add(5)
        stack.add(6)
        self.assertEqual(stack.get_stack(), [1, 2, 3, 4, 5, 6])

    def test_get_stack_returns_empty_list_for_empty_stack(self):
        stack = Stack()
        self.assertEqual(stack.get_stack(), [])


if __name__ == '__main__':
    unittest.main()