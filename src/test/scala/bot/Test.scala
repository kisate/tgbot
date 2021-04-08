package bot

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class Test extends AnyFunSuite with Matchers {
  test("check")(assert(2==2))
}