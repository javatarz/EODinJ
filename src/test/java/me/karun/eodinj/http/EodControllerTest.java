package me.karun.eodinj.http;

import lombok.val;
import me.karun.eodinj.db.MessageRepository;
import me.karun.eodinj.http.model.UpdateEntryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static me.karun.eodinj.http.ListUtils.joinedList;
import static me.karun.eodinj.http.MessageGenerator.generateMessages;
import static me.karun.eodinj.http.model.Topic.action;
import static me.karun.eodinj.http.model.Topic.story;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EodControllerTest {

  @Mock
  private MessageRepository repository;

  @Test
  public void shouldFetchUpdatesGroupedByTopic() {
    val today = LocalDate.now();
    val storyList = generateMessages(2, story, today);
    val actionList = generateMessages(6, action, today);
    when(repository.findByDateOrderByTopic(eq(today))).thenReturn(joinedList(storyList, actionList));

    val controller = new EodController(repository);

    assertThat(controller.fetchByDate(today.toString()))
      .containsExactlyInAnyOrder(new UpdateEntryResponse(story, storyList), new UpdateEntryResponse(action, actionList));
  }
}
