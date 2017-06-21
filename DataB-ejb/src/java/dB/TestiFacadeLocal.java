/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dB;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jukka
 */
@Local
public interface TestiFacadeLocal {

    void create(Testi testi);

    void edit(Testi testi);

    void remove(Testi testi);

    Testi find(Object id);

    List<Testi> findAll();

    List<Testi> findRange(int[] range);

    int count();
    
}
