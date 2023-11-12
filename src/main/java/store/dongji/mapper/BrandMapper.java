package store.dongji.mapper;

import store.dongji.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    void add(Brand brand);

    Brand selectById(Integer id);
}
