package UI.ListaAspirantes.ListaAspirante1280x1024;

import UI.ListaAspirantes.ItemListView;
import UI.ListaAspirantes.ItemListViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class ItemListView1280x1024 extends ItemListView
{

    @Override
    protected Double getSizeLabel() {
        return 13.0;
    } //tamañoTexto

    @Override
    protected Double getSizeIconLabel() {    //tamaño icono
        return 22.0;
    }

    @Override
    protected Double getGraphicTextGap() {
        return 10.0;
    } //Espacio entre icono y texto

    @Override
    protected Double getLabelPadding() {
        return 3.0;
    }

    @Override
    protected Double getAlturaListView() {
        return 211.0;
    }

    @Override
    protected Double getVerticalGapListView() {
        return 8.0;
    }  //espacio entre label de la list view

    @Override
    protected Double getAnchoListView() {
        return 170.0;
    }

    @Override
    protected Double popupInitialPositionX() {
        return -191.0;
    }

    @Override
    protected Double popupInitialPositionY() {
        return 12.0;
    }

    @Override
    protected double desplazamientoMostarMenuEditar() {
        return -967;
    }

    @Override
    protected double desplazamientoEliminarAspirante() {
        return 967;
    }

}