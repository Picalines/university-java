package practice7;

interface DrunkardHandUpdatedListener {
    void onTopCardTaken(DrunkardHand hand, DrunkardCard card);
    void onCardWasPutUnderneath(DrunkardHand hand, DrunkardCard card);
}

public class ObservableDrunkardHand extends DrunkardHand {
    private final DrunkardHand hand;
    private DrunkardHandUpdatedListener updatedListener;

    public ObservableDrunkardHand(DrunkardHand hand) {
        super(hand.getPlayer());
        this.hand = hand;
        updatedListener = null;
    }

    public void listenToUpdate(DrunkardHandUpdatedListener listener) {
        updatedListener = listener;
    }

    @Override
    public DrunkardCard takeTopCard() {
        var topCard = hand.takeTopCard();
        if (updatedListener != null) updatedListener.onTopCardTaken(hand, topCard);
        return topCard;
    }

    @Override
    public void putCartUnderneath(DrunkardCard card) {
        hand.putCartUnderneath(card);
        if (updatedListener != null) updatedListener.onCardWasPutUnderneath(hand, card);
    }

    @Override
    public boolean isEmpty() {
        return hand.isEmpty();
    }
}
