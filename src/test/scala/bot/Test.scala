package bot

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class Test extends AnyFunSuite with Matchers {
  test("check")(assert(2 == 2))

  val ainur = User("ainur", "ibatov", "ainur19dota2@yandex.ru", "etovamnesiria", Calendar(List.empty))
  val kirill = User("kirill", "gavrilov", "cgawrilowapple10@yandex.ru", "bashkiria", Calendar(List.empty))
  val guk = User("dima", "guk", "kisateochev@yandex.ru", "moirodimiikrai", Calendar(List.empty))
  val shura = User("sasha", "kuzmina", "kuzminash@yandex.ru", "lalala", Calendar(List.empty))

  test("simple interaction with ConcurrentHashMapRepository") {
    val repo = new UserRepository()
    repo.save(ainur, 0)
    repo.save(kirill, 1)
    assert(repo.getAll.size == 2)
  }

  test("maxload ConcurrentHashMapRepository") {
    val repo = new UserRepository()
    repo.save(ainur, 0)
    repo.save(kirill, 1)
    repo.save(guk, 2)
    repo.save(shura, 7)

    assert(repo.getAll == List((0, ainur), (1, kirill), (2, guk), (7, shura)))
  }

  test("minload ConcurrentHashMapRepository") {
    val repo = new UserRepository()

    assert(repo.getAll == List.empty)
  }
}