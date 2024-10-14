package java02;

public class Main {

    public static void main(String[] args) {
        FruitBuyer buyer = new FruitBuyer();
        FruitSeller seller = new FruitSeller();

        seller.sellApple(buyer, 2);

        System.out.println("과일 판매자의 현재 상황");
        seller.showSellResult();

        System.out.println("과일 구매자의 현재 상황");
        buyer.showBuyResult();
    }
}

class FruitSeller {

    private int numOfApple = 20;
    private int myMoney = 0;
    private final int APPLE_PRICE = 1000;

    // 사과 판매 함수
    // 1. 판매자의 상태변화 함수 실행
    // 2. 전달받은 구매자의 상태변화 함수 실행
    public void sellApple(FruitBuyer buyer, int appleBuyCount) {
        // 판매자 상태 변화
        updateSellerState(appleBuyCount);
        // 구매자 상태 변화
        buyer.updateBuyerState(APPLE_PRICE, appleBuyCount);
    }

    private void updateSellerState(int appleBuyCount) {
        // 판매한 사과 금액만큼 보유 금액 증가
        myMoney += appleBuyCount * APPLE_PRICE;
        // 판매한 사과 갯수만큼 사과 갯수 차감
        numOfApple -= appleBuyCount;
    }

    public void showSellResult() {
        System.out.println("남은 사과 : " + numOfApple);
        System.out.println("판매 수익 : " + myMoney);
    }
}

class FruitBuyer {

    private int numOfApple = 0;
    private int myMoney = 5000;

    public void updateBuyerState(int applePrice, int appleBuyCount) {
        // 구매한 사과 갯수만큼 보유 금액 차감
        myMoney -= appleBuyCount * applePrice;
        // 구매한 사과 갯수만큼 사과 갯수 증가
        numOfApple += appleBuyCount;
    }

    public void showBuyResult() {
        System.out.println("현재 잔액 : " + myMoney);
        System.out.println("사과 개수 : " + numOfApple);
    }
}
