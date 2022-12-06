package com.example.kata_spring;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class AlimentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("#GroupeTest1")
    @Nested
    class ListerLesAliments {
        @Test
        public void test_1_1() throws Exception {
            // Arrange
            JSONObject aliment1 = new JSONObject();
            aliment1.put("nom", "pomme");
            aliment1.put("categorie", "fruit");
            aliment1.put("couleur", "rouge");

            JSONObject aliment2 = new JSONObject();
            aliment2.put("nom", "banane");
            aliment2.put("categorie", "fruit");
            aliment2.put("couleur", "jaune");

            JSONObject aliment3 = new JSONObject();
            aliment3.put("nom", "broccoli");
            aliment3.put("categorie", "legume");
            aliment3.put("couleur", "vert");

            JSONObject aliment4 = new JSONObject();
            aliment4.put("nom", "carotte");
            aliment4.put("categorie", "legume");
            aliment4.put("couleur", "orange");

            JSONObject aliment5 = new JSONObject();
            aliment5.put("nom", "poulet");
            aliment5.put("categorie", "viande");
            aliment5.put("couleur", "blanc");

            JSONObject aliment6 = new JSONObject();
            aliment6.put("nom", "saumon");
            aliment6.put("categorie", "fruit de mer");
            aliment6.put("couleur", "rose");

            JSONObject aliment7 = new JSONObject();
            aliment7.put("nom", "moule");
            aliment7.put("categorie", "fruit-de-mer");
            aliment7.put("couleur", "rose");

            JSONObject aliment8 = new JSONObject();
            aliment7.put("nom", "crabe");
            aliment7.put("categorie", "fruit de mer");
            aliment7.put("couleur", "rose");

            JSONArray listeAlimentsAttendu = new JSONArray();
            listeAlimentsAttendu.put(aliment1);
            listeAlimentsAttendu.put(aliment2);
            listeAlimentsAttendu.put(aliment3);
            listeAlimentsAttendu.put(aliment4);
            listeAlimentsAttendu.put(aliment5);
            listeAlimentsAttendu.put(aliment6);
            listeAlimentsAttendu.put(aliment7);
            listeAlimentsAttendu.put(aliment8);

            // Act
            mockMvc.perform(get("/aliments")).andDo(print())
                    // Assert
                    .andExpect(status().isOk())
                    .andExpect(content().json(listeAlimentsAttendu.toString(), true));
        }
    }
    @DisplayName("#GroupeTest2")
    @Nested
    class ListerLeDetailDesAliments {
        @Test
        public void test_2_1() throws Exception {
            // Arrange
            JSONObject detailAliments = new JSONObject();
            detailAliments.put("nbFruit", 2);
            detailAliments.put("nbLegume", 2);
            detailAliments.put("nbViande", 1);
            detailAliments.put("nbFruitDeMer", 3);

            // Act
            mockMvc.perform(get("/detail-aliments")).andDo(print())
                    // Assert
                    .andExpect(status().isOk())
                    .andExpect(content().json(detailAliments.toString(), true));
        }
    }
}