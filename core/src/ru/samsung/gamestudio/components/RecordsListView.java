package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.samsung.gamestudio.GameSettings;

import java.util.ArrayList;

public class RecordsListView extends TextView {

    // Изменено: добавлена поддержка выравнивания по заданному X
    public RecordsListView(BitmapFont font, float y) {
        super(font, 0, y, "");
        shouldCenterX = true;
    }

    // Изменено: добавлен конструктор с настройкой выравнивания
    public RecordsListView(BitmapFont font, float x, float y, boolean shouldCenterX) {
        super(font, x, y, "");
        this.shouldCenterX = shouldCenterX;
    }

    private boolean shouldCenterX = true;

    public void setRecords(ArrayList<Integer> recordsList) {
        text = "";
        int countOfRows = Math.min(recordsList.size(), 5);
        for (int i = 0; i < countOfRows; i++) {
            System.out.println(recordsList.get(i));
            text += (i + 1) + ". - " + recordsList.get(i) + "\n";
        }

        GlyphLayout glyphLayout = new GlyphLayout(font, text);
        width = glyphLayout.width;
        height = glyphLayout.height;
        if (shouldCenterX) {
            x = (GameSettings.SCREEN_WIDTH - glyphLayout.width) / 2;
        }
    }

}
