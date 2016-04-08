package hossam.mejiaasociados;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by Hossam on 4/8/2016.
 */
public class Splash extends AwesomeSplash {



    @Override
    public void initSplash(ConfigSplash configSplash) {



        configSplash.setBackgroundColor(R.color.color_primary);
        configSplash.setAnimCircularRevealDuration(2000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        configSplash.setLogoSplash(R.drawable.icon);
        configSplash.setAnimLogoSplashDuration(30);
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce);

        configSplash.setTitleSplash(getResources().getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont("fonts/volatire.ttf");

    }

    @Override
    public void animationsFinished() {

        startActivity(new Intent(Splash.this, LoginActivity.class));
        this.finish();

    }
}
