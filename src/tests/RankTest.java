package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Rank;

public class RankTest {

  @Test
  public void testgetValues() {
    assertEquals(2, Rank.DEUCE.getValue());
  }

}