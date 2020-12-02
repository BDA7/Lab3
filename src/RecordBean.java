import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Arrays;

@ManagedBean(name = "Record", eager = true)
@ApplicationScoped
public class RecordBean implements Serializable {

    private Double x;
    private Double y;
    private Double r;

    private Boolean inArea;


    public RecordBean() {
        this.x = 0.;
        this.y = 0.;
        this.r = 1.;
        this.inArea = false;
    }

    public void onSubmit() {
        inArea = Result.calculate(x, y, r);
        Result result = new Result(x, y, r, inArea);
        result.save();
    }

    public void onXChecked(Double value){
        if (Arrays.asList(-3d,-2d,-1d,0d,1d,2d,3d,4d,5d).contains(value))
            this.x = value;
    }

    public void onRChecked(Double value) {
        if (Arrays.asList(1d, 1.5d, 2d, 2.5d, 3d).contains(value))
            this.r = value;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String ready() {
        return "success";
    }

    public String back() {
        return "success";
    }
}
