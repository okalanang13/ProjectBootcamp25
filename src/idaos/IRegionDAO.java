/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author Okala
 */
public interface IRegionDAO {

    public List<Region> getData(Object key, boolean isGetById);

    public boolean save(Region r);

    public boolean delete(int id);
}
