package com.spacex.service;

import com.spacex.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    public List<Carousel> queryAll(int isShow);
}
