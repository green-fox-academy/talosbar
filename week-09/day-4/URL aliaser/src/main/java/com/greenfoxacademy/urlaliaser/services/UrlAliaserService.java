package com.greenfoxacademy.urlaliaser.services;

import com.greenfoxacademy.urlaliaser.models.Link;
import java.util.List;

public interface UrlAliaserService {

  void addLink(Link link);

  List<Link> returnAllLinks();

  boolean isSecretCodeMatching(Link link, Integer secretCode);

  boolean isAliasExists(Link link);

  Link findById(long id);

  Link findByAlias(String alias);

  void delete(Long id);
}
