package mx.ebc

import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*
import java.util.stream.*
import static org.junit.jupiter.api.Assertions.*
import static org.junit.jupiter.api.DynamicTest.dynamicTest

class ApplicationTest {

  @Test
  void testSomething(){
    assertEquals(2, 1 + 1)
  }

  @Test
  void streamSum() {
    assertTrue(Stream.of(1, 2, 3)
      .mapToInt(i -> i)
      .sum() > 5, () -> "Sum should be greater than 5")
  }

  @RepeatedTest(value=2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
  void streamSumRepeated() {
    assert Stream.of(1, 2, 3).mapToInt(i -> i).sum() == 6
  }

  private boolean isPalindrome(s) { s == s.reverse()  }

  @ParameterizedTest
  @ValueSource(strings = [ "racecar", "radar", "able was I ere I saw elba" ])
  void palindromes(String candidate) {
    assert isPalindrome(candidate)
  }

  @TestFactory
  def dynamicTestCollection() {[
  dynamicTest("Add test") { -> assert 1 + 1 == 2 },
  dynamicTest("Multiply Test", () -> { assert 2 * 3 == 6 })
  ]}
}
