package Model.FamiliaFXML;

import javafx.stage.Stage;

public abstract class FamilyFXML
{
    public abstract Stage loadLogin();

    protected Stage createStage(int MaxWidth, int MaxHeight, int MinWidth, int MinHeight, int Width, int Height)
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
