package mj.apps.rxandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    private Observer<Integer> getFirstObserver() {
        Observer<Integer> firstObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "First " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return firstObserver;
    }
    
    private Observer<Integer> getSecondObserber() {
        Observer<Integer> secondObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "Second " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return secondObserver;
    }
}
