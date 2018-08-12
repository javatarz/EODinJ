package me.karun.eodinj.http.model;


import org.apache.commons.text.WordUtils;

public enum Topic implements Comparable<Topic> {
  story, action, others;

  @Override
  public String toString() {
    return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
  }
}
