package com.greenfoxacademy.urlaliaser.services;

import com.greenfoxacademy.urlaliaser.models.Link;
import java.util.List;
import javassist.NotFoundException;

public interface UrlAliaserService {

  void addLink(Link link);

  List<Link> returnAllLinks();

  boolean isAliasExists(String alias);

  Link findById(long id);

  Link findByAlias(String alias);

  void deleteLinkBySecretCode(String secretCode, long id) throws NotFoundException;
}
