//import $ivy.`org.scalatest:scalatest_2.11:3.0.1`

//import $ivy.`org.scalatest::scalatest:3.0.1`


interp.load.ivy("org.scalactic" %% "scalactic" % "3.0.1")


import org.scalatest._

import org.scalatest.FunSuite


class SetSuite extends FunSuite {

               test("An empty Set should have size 0") {
                 assert(Set.empty.size == 0)
               }

               test("Invoking head on an empty Set should produce NoSuchElementException") {
                 assertThrows[NoSuchElementException] {
                   Set.empty.head
                 }
               }
             }


 (new SetSuite).execute()



 import org.scalatest.FlatSpec
 import collection.mutable.Stack
 import org.scalatest._


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

(new StackSpec).execute()




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
