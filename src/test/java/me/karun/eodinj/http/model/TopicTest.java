package me.karun.eodinj.http.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopicTest {
  @Test
  public void shouldCapitalizeTopicNamesFully() {
    assertThat(Topic.story.toString()).isEqualTo("story");
  }
}
