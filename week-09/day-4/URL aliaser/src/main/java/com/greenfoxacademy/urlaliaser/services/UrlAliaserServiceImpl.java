package com.greenfoxacademy.urlaliaser.services;

import com.greenfoxacademy.urlaliaser.dtos.SecretDTO;
import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.repositories.UrlAliaserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javassist.NotFoundException;
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
    Random random = new Random();
    link.setSecretCode(String.format("%04d", random.nextInt(10000)));
    urlAliaserRepository.save(link);
  }

  @Override
  public List<Link> returnAllLinks() {
    List<Link> links = new ArrayList<>();
    urlAliaserRepository.findAll().forEach(links::add);
    return links;
  }

  @Override
  public boolean isAliasExists(String alias) {
    return urlAliaserRepository.findByAlias(alias).isPresent();
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
  public void deleteLinkBySecretCode(String secretCode, long id) throws NotFoundException {
    Optional<Link> optionalLink = urlAliaserRepository.findById(id);

    if (optionalLink.isPresent()) {
      Link storedLink = optionalLink.get();
      if (storedLink.getSecretCode().equals(secretCode)) {
        urlAliaserRepository.delete(storedLink);
      } else {
        throw new IllegalArgumentException("Secret code is not valid");
      }
    } else {
      throw new NotFoundException("Link with the given ID cannot be found");
    }
  }
}