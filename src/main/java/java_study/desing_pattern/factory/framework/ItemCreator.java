package java_study.desing_pattern.factory.framework;

public abstract class ItemCreator {

    public Item create() {
        requestItemsInfo();
        createItemLog();
        return createItem();
    }

    //DB에 아이템 생성 요청
    abstract protected void requestItemsInfo();
    //DB에 아이템 정보 로그 남김
    abstract protected void createItemLog();
    //아이템 생성
    abstract protected Item createItem();

}
