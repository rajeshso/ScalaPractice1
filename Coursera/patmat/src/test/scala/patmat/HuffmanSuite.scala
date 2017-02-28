package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeCodeTree(\"xet\")") {
    val sampleTree = makeCodeTree(
      makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
      Leaf('t', 2)
    )
    assert(chars(sampleTree) === List('x','e','t'))
  }

  test("times(\"xet\")") {
    val x : List[Char] = 'x' :: 'e' :: 't' :: Nil
    assert(times(x) === List(('x', 1), ('e',1), ('t',1)));
  }

  test("times(\"aba\")") {
    val x : List[Char] = 'a' :: 'b' :: 'a' :: Nil
    assert(times(x) === List(('a', 2), ('b',1)));
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton(\"aba\")") {
    val x1 : List[CodeTree] = List(Fork(Leaf('a',1),Leaf('b',2), List('a','b'), 3))
    assert(singleton(x1) === true);
  }

  test("singleton(\"a\")") {
    val x1 : List[CodeTree] = List(Leaf('a',1))
    assert(singleton(x1) === true);
  }

/*  ignore("non singleton(\"efgh\")") {
    val x1 : List[CodeTree] = List(Fork(
      Fork(Leaf('e',1),Leaf('f',1),List('e','f'),2),
      Fork(Leaf('g',1),Leaf('h',1),List('g','h'),2),
      List('e','f','g','h'),
      4))
    assert(singleton(x1) === false);
  }*/

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  test("combine 2 leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3)))
  }
  test("combine 1 leaf list") {
    val leaflist = List(Leaf('e', 1))
    assert(combine(leaflist) === List((Leaf('e',1))))
  }

  test("decode t1 and find 1=b") {
    val bits : List[Bit] = List(1)
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    assert(decode(t1,bits) == List('b'))
  }
  test("decode t1 and find 0=a") {
    val bits : List[Bit] = List(0)
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    assert(decode(t1,bits) == List('a'))
  }
  test("encode for t1 and find b=1") {
    val bits : List[Bit] = List(1)
    val charList : List[Char] = List('b')
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    assert(encode(t1)(charList) == bits)
  }
  test("encode t1 and find a=0") {
    val bits : List[Bit] = List(0)
    val charList : List[Char] = List('a')
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    assert(encode(t1)(charList) == bits)
  }
/*  ignore("encode t2 and find all") {
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    assert(encode(t2)(('a'::'b'::Nil)) == List(0)) //List(0, 0, 0, 1) did not equal List(0)
    assert(encode(t2)(('d'::Nil)) == List(1))
    assert(encode(t2)(('a'::Nil)) == (0::0::Nil))
    assert(encode(t2)(('b'::Nil)) == List(0,1))
  }*/
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
