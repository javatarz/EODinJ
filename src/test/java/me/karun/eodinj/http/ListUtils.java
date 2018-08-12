package me.karun.eodinj.http;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableList;

class ListUtils {
  static <T> List<T> joinedList(final List<T> list1, final List<T> list2) {
    return Stream.of(list1, list2).flatMap(Collection::stream)
      .collect(toUnmodifiableList());
  }
}
