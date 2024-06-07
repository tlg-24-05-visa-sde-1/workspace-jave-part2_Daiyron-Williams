package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findCheapRock_shouldReturnCheapClassicRock_inputIsValid() {
        Collection<MusicItem> rockItem = catalog.findByCategory(MusicCategory.CLASSIC_ROCK);

        assertEquals(1, rockItem.size());

        for(MusicItem item : rockItem) {
            assertEquals(MusicCategory.CLASSIC_ROCK, item.getMusicCategory());
        }
    }

    @Test
    public void findSelfTitled_shouldReturnCollection() {
        Collection<MusicItem> items = catalog.findSelfTitled();

        assertEquals(2, items.size());

        for (MusicItem item : items) {
            assertEquals(item.getArtist(), item.getTitle());
        }
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryNotFound() {
        Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);

        assertNotNull(jazzItems);
        assertTrue(jazzItems.isEmpty());
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);

        assertEquals(4, popItems.size());

        for(MusicItem item : popItems) {
            assertEquals(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        //  make the business call, null should come back
        MusicItem item = catalog.findById(101L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_idFound() {
        //  make the business call, a non-null MusicItem should come back
        MusicItem item = catalog.findById(6L);

        assertNotNull(item);
        assertEquals(6L, item.getId().longValue()); //  long, long
    }
}