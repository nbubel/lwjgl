package com.bit.lake.lwjgl.twitter;

import org.junit.Test;

import java.util.List;

public class TwitterAdapterServiceTest {

    @Test
    public void testServiceCall() throws  Exception {
        TwitterAdapterService service = new TwitterAdapterService();
        List<TwitterCardModel> result = service.getCardsFor("blub", 5);
        result.forEach(System.out::println);
    }
}
