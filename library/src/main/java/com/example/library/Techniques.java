package com.example.library;

import com.example.library.attention.BounceAnimator;
import com.example.library.attention.FlashAnimator;
import com.example.library.attention.PulseAnimator;
import com.example.library.attention.RubberBandAnimator;
import com.example.library.attention.ShakeAnimator;
import com.example.library.attention.StandUpAnimator;
import com.example.library.attention.SwingAnimator;
import com.example.library.attention.TadaAnimator;
import com.example.library.attention.WaveAnimator;
import com.example.library.attention.WobbleAnimator;
import com.example.library.bouncing_entrances.BounceInAnimator;
import com.example.library.bouncing_entrances.BounceInDownAnimator;
import com.example.library.bouncing_entrances.BounceInLeftAnimator;
import com.example.library.bouncing_entrances.BounceInRightAnimator;
import com.example.library.bouncing_entrances.BounceInUpAnimator;
import com.example.library.fading_entrances.FadeInAnimator;
import com.example.library.fading_entrances.FadeInDownAnimator;
import com.example.library.fading_entrances.FadeInLeftAnimator;
import com.example.library.fading_entrances.FadeInRightAnimator;
import com.example.library.fading_entrances.FadeInUpAnimator;
import com.example.library.fading_exits.FadeOutAnimator;
import com.example.library.fading_exits.FadeOutDownAnimator;
import com.example.library.fading_exits.FadeOutLeftAnimator;
import com.example.library.fading_exits.FadeOutRightAnimator;
import com.example.library.fading_exits.FadeOutUpAnimator;
import com.example.library.flippers.FlipInXAnimator;
import com.example.library.flippers.FlipInYAnimator;
import com.example.library.flippers.FlipOutXAnimator;
import com.example.library.flippers.FlipOutYAnimator;
import com.example.library.rotating_entrances.RotateInAnimator;
import com.example.library.rotating_entrances.RotateInDownLeftAnimator;
import com.example.library.rotating_entrances.RotateInDownRightAnimator;
import com.example.library.rotating_entrances.RotateInUpLeftAnimator;
import com.example.library.rotating_entrances.RotateInUpRightAnimator;
import com.example.library.rotating_exits.RotateOutAnimator;
import com.example.library.rotating_exits.RotateOutDownLeftAnimator;
import com.example.library.rotating_exits.RotateOutDownRightAnimator;
import com.example.library.rotating_exits.RotateOutUpLeftAnimator;
import com.example.library.rotating_exits.RotateOutUpRightAnimator;
import com.example.library.sliders.SlideInDownAnimator;
import com.example.library.sliders.SlideInLeftAnimator;
import com.example.library.sliders.SlideInRightAnimator;
import com.example.library.sliders.SlideInUpAnimator;
import com.example.library.sliders.SlideOutDownAnimator;
import com.example.library.sliders.SlideOutLeftAnimator;
import com.example.library.sliders.SlideOutRightAnimator;
import com.example.library.sliders.SlideOutUpAnimator;
import com.example.library.specials.HingeAnimator;
import com.example.library.specials.RollInAnimator;
import com.example.library.specials.RollOutAnimator;
import com.example.library.specials.in.DropOutAnimator;
import com.example.library.specials.in.LandingAnimator;
import com.example.library.specials.out.TakingOffAnimator;
import com.example.library.zooming_entrances.ZoomInAnimator;
import com.example.library.zooming_entrances.ZoomInDownAnimator;
import com.example.library.zooming_entrances.ZoomInLeftAnimator;
import com.example.library.zooming_entrances.ZoomInRightAnimator;
import com.example.library.zooming_entrances.ZoomInUpAnimator;
import com.example.library.zooming_exits.ZoomOutAnimator;
import com.example.library.zooming_exits.ZoomOutDownAnimator;
import com.example.library.zooming_exits.ZoomOutLeftAnimator;
import com.example.library.zooming_exits.ZoomOutRightAnimator;
import com.example.library.zooming_exits.ZoomOutUpAnimator;

public enum Techniques {

    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),

    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);



    private Class animatorClazz;

    private Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
