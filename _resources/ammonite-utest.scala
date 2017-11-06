//"com.lihaoyi" %% "utest" % "0.5.3" % "test"


import $ivy.`com.lihaoyi:utest_2.11:0.5.3`

import utest._

val tests = Tests{
  'test1 - {
    // throw new Exception("test1")
  }
  'test2 - {
    'inner - {
      1
    }
  }
  'test3 - {
    val a = List[Byte](1, 2)
    // a(10)
  }
}



// Run and return results
val results1 = TestRunner.run(tests)





;;;;;;;;



interp.load.ivy( "com.lihaoyi" %% "utest" % "0.5.3")


import utest._

 val tests = Tests{
    'test1 - {
      // throw new Exception("test1")
    }
    'test2 - {
      'inner - {
        1
      }
    }
    'test3 - {
      val a = List[Byte](1, 2)
      // a(10)
    }
  }


 // Run and return results

 val results1 = TestRunner.run(tests)

 val results1 = TestRunner.runAndPrint(tests)

 val results1 = TestRunner.runAndPrint(tests, "MySuite")




;;;;;;;;;;;;




val tests = Tests {
  "testSuccess" - {
    Future {
      assert(true)
    }
  }
  "testFail" - {
    Future {
      assert(false)
    }
  }
  "normalSuccess" - {
    assert(true)
  }
  "normalFail" - {
    assert(false)
  }
}

tests.runAsync().map { results =>
  assert(results.toSeq(0).value.isSuccess) // root
  assert(results.toSeq(1).value.isSuccess) // testSuccess
  assert(results.toSeq(2).value.isFailure) // testFail
  assert(results.toSeq(3).value.isSuccess) // normalSuccess
}









val tests = Tests{
  'test1 - {
    // throw new Exception("test1")
  }
  'test2 - {
    'inner - {
      1
    }
  }
  'test3 - {
    val a = List[Byte](1, 2)
    // a(10)
  }
}

// Run and return results
val results1 = TestRunner.run(tests)



// Run, return results, and print streaming output with the default formatter
val results2 = TestRunner.runAndPrint(
  tests,
  "MyTestSuiteA"
)
// Run, return results, and print output with custom formatter and executor
val results3 = TestRunner.runAndPrint(
  tests,
  "MyTestSuiteA",
  executor = new utest.framework.Executor{
    override def utestWrap(path: Seq[String], runBody: => Future[Any])
                 (implicit ec: ExecutionContext): Future[Any] = {
      println("Getting ready to run " + path.mkString("."))
      runBody
    }
  },
  formatter = new utest.framework.Formatter{
    override def formatColor = false
  }
)


object MyTestSuite extends TestSuite{
  val tests = Tests{
    'test1 - {
      // throw new Exception("test1")
    }
    'test2 - {
      'inner - {
        1
      }
    }
    'test3 - {
      val a = List[Byte](1, 2)
      // a(10)
    }
  }
}

val results4 = TestRunner.runAndPrint(
  MyTestSuite.tests,
  "MyTestSuiteB",
  executor = MyTestSuite,
  formatter = MyTestSuite
)


// Show summary and exit
val (summary, successes, failures) = TestRunner.renderResults(
  Seq(
    "MySuiteA" -> results1,
    "MySuiteA" -> results2,
    "MySuiteA" -> results3,
    "MySuiteB" -> results4
  )
)
if (failures > 0) sys.exit(1)


;;;;;;;;


// Run `TestSuite` object directly without using SBT, and use
// its configuration for execution and output formatting
object MyTestSuite extends TestSuite{
  val tests = Tests{
    'test1 - {
      // throw new Exception("test1")
    }
    'test2 - {
      'inner - {
        1
      }
    }
    'test3 - {
      val a = List[Byte](1, 2)
      // a(10)
    }
  }
}

val results4 = TestRunner.runAndPrint(
  MyTestSuite.tests,
  "MyTestSuiteB",
  executor = MyTestSuite,
  formatter = MyTestSuite
)



;;;;;;;;








