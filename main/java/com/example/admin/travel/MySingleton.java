package com.example.admin.travel;

/**
 * Created by Sharu on 26/3/2016.
 */



import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
    public class MySingleton {

        private static MySingleton mInstance;
        private RequestQueue mRequestQueue;
        private ImageLoader mImageLoader;
        private static Context mCtx;

        private MySingleton(Context context) {
            mCtx = context;
            mRequestQueue = getRequestQueue();

            // Use the custome made bitmap cache class so delete the commented out sections
    /*    mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);
    */
            mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache(
                    LruBitmapCache.getCacheSize(mCtx)));

    /*              @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }
                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    */
        }

        public static synchronized MySingleton getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new MySingleton(context);
            }
            return mInstance;
        }

        public RequestQueue getRequestQueue() {
            if (mRequestQueue == null) {
                // getApplicationContext() is key, it keeps you from leaking the
                // Activity or BroadcastReceiver if someone passes one in.
                mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
            }
            return mRequestQueue;
        }

        public <T> void addToRequestQueue(Request<T> req) {
            getRequestQueue().add(req);
        }

        public ImageLoader getImageLoader() {
            return mImageLoader;
        }
    }
