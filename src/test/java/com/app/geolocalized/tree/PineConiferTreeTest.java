package com.app.geolocalized.tree;

import com.app.geolocalized.model.tree.conifer.Conifer;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Getter
@Setter
public class PineConiferTreeTest {

    private Conifer pine;

}
