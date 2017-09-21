import collection.mutable.Stack


import $ivy.`org.scalatest:scalatest_2.11:3.0.1`
import org.scalatest._
/*
import org.scalatest.Assertions
import org.scalatest.Assertions.assertionsHelper
Assertions.assert(2 == 2)
*/
class StackSpec extends FlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}

//run(new StackSpec)

//org.scalatest.run(new StackSpec)