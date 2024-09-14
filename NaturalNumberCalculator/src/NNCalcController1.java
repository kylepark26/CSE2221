import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Kyle Park
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        // TODO: fill in body

        NaturalNumber top = model.bottom();
        NaturalNumber bottom = model.top();

        view.updateBottomDisplay(top);
        view.updateTopDisplay(bottom);

        view.updateDivideAllowed(top.compareTo(new NaturalNumber2()) > 0);
        view.updateSubtractAllowed(top.compareTo(bottom) < 0);
        view.updatePowerAllowed(top.compareTo(INT_LIMIT) < 0);
        view.updateRootAllowed(
                top.compareTo(TWO) >= 0 && top.compareTo(INT_LIMIT) <= 0);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.copyFrom(bottom);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.add(bottom);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.subtract(bottom);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.multiply(bottom);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber remainder = top.divide(bottom);
        bottom.transferFrom(top);
        top.transferFrom(remainder);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        int exponent = bottom.toInt();
        top.power(exponent);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        // TODO: fill in body

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        int root = bottom.toInt();
        top.root(root);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        // TODO: fill in body

        NaturalNumber bottom = this.model.bottom();
        bottom.multiplyBy10(digit);
        updateViewToMatchModel(this.model, this.view);

    }

}
