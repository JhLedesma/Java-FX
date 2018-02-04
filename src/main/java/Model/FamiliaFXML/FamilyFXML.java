package Model.FamiliaFXML;

import javafx.stage.Stage;

public abstract class FamilyFXML
{
    int MaxHeight;
    int MaxWidth;
    int MinHeight;
    int MinWidth;
    int Height;
    int Width;

    public FamilyFXML(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        MaxHeight = maxHeight;
        MaxWidth = maxWidth;
        MinHeight = minHeight;
        MinWidth = minWidth;
        Height = height;
        Width = width;
    }

    public abstract Stage loadLogin();

    public abstract Stage loadListaAspirantes();

    protected Stage createStage()
    {
        Stage stage = new Stage();

        stage.setMaxHeight(MaxHeight);
        stage.setMaxWidth(MaxWidth);
        stage.setMinHeight(MinHeight);
        stage.setMinWidth(MinWidth);
        stage.setHeight(Height);
        stage.setWidth(Width);

        return stage;
    }
}
