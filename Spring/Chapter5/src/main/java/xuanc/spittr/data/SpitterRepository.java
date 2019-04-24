package xuanc.spittr.data;

import xuanc.spittr.Spitter;

/**
 * @author xuanc
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
