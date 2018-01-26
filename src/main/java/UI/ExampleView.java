package UI;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ExampleView implements FxmlView<ExampleViewModel>
{

    @InjectViewModel
    private ExampleViewModel viewModel;

    @FXML
    private Label helloLabel;


    public void initialize()
    {
        helloLabel.textProperty().bind(viewModel.helloMessageProperty());
    }
}