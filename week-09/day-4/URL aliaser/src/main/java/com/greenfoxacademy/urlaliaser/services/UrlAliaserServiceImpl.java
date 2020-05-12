package com.greenfoxacademy.urlaliaser.services;

import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.repositories.UrlAliaserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlAliaserServiceImpl implements UrlAliaserService {

  UrlAliaserRepository urlAliaserRepository;

  @Autowired
  public UrlAliaserServiceImpl(
      UrlAliaserRepository urlAliaserRepository) {
    this.urlAliaserRepository = urlAliaserRepository;
  }

  @Override
  public void addLink(Link link) {
    urlAliaserRepository.save(link);
  }

  @Override
  public List<Link> returnAllLinks() {
    List<Link> links = new ArrayList<>();
    urlAliaserRepository.findAll().forEach(links::add);
    return links;
  }

  @Override
  public boolean isSecretCodeMatching(Link link, Integer secretCode) {
    if (link.getSecretCode().equals(secretCode)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isAliasExists(Link link) {
    if (urlAliaserRepository.findByAlias(link.getAlias()).isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Link findById(long id) {
    Link link = new Link();
    Optional<Link> optionalLink = urlAliaserRepository.findById(id);
    if (optionalLink.isPresent()) {
      link = optionalLink.get();
    }
    return link;
  }

  @Override
  public Link findByAlias(String alias) {
    Link link = new Link();
    Optional<Link> optionalLink = urlAliaserRepository.findByAlias(alias);
    if (optionalLink.isPresent()) {
      link = optionalLink.get();
    }
    return link;
  }

  @Override
  public void delete(Long id) {
    urlAliaserRepository.delete(findById(id));
  }
}
