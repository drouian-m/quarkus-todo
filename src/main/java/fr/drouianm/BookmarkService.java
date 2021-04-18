package fr.drouianm;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class BookmarkService {
  /**
   * Fetch all bookmarks
   * @return bookmarks list
   */
  public List<Bookmark> fetch() {
    return Bookmark.listAll(Sort.by("createdAt"));
  }

  public Bookmark findById(Long id) {
    return Bookmark.findById(id);
  }

  public Bookmark create(Bookmark bookmark) {
    bookmark.createdAt = new Date();
    bookmark.updatedAt = bookmark.createdAt;
    bookmark.persist();
    return bookmark;
  }

  public Bookmark update(Long id, Bookmark update) {
    Bookmark bookmark = Bookmark.findById(id);
    bookmark.title = update.title;
    bookmark.description = update.description;
    bookmark.link = update.link;
    bookmark.tags = update.tags;
    bookmark.updatedAt = new Date();
    bookmark.persist();
    return bookmark;
  }

  public void delete(Long id) {
    Bookmark bookmark = Bookmark.findById(id);
    bookmark.delete();
  }
}
