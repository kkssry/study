package java_study.desing_pattern.observer;

public class Button {

    // 이벤트 처리
    public void onClick() {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public interface OnClickListener {
        public void onClick(Button button);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}
