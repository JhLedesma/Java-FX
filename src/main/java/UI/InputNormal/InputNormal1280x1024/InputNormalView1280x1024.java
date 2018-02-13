package UI.InputNormal.InputNormal1280x1024;

import UI.InputNormal.InputNormalViewModel;;
import com.jfoenix.controls.JFXScrollPane;
import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class InputNormalView1280x1024 implements FxmlView<InputNormalViewModel>, Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //scrollPane.setContent();
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    }


    @FXML private ScrollPane scrollP;

}
