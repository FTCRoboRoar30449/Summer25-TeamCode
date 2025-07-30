package pedroPathing.examples;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

private final Pose startPose = new Pose(135, 50, Math.toRadians(0));  // Starting/idle position
private final Pose dropPose = new Pose(125, 25, Math.toRadians(135)); // Scoring/high basket position

private final Pose preStaged1Pose = new Pose(115, 25, Math.toRadians(180)); // First Pre-staged sample pickup
private final Pose preStaged2Pose = new Pose(115, 15, Math.toRadians(180)); // Second Pre-staged sample pickup
private final Pose preStaged3Pose = new Pose(115, 12, Math.toRadians(215)); // Third Pre-staged sample pickup
private final Pose subPose = new Pose(72, 40, Math.toRadians(90)); // sub pickup/position
private final Pose endPose = new Pose(72, 45, Math.toRadians(-90));    // Endgame position - low rung

        private Path scorePreload, park;
        private PathChain grabPickup1, grabPickup2, grabPickup3, scorePickup1, scorePickup2, scorePickup3;

public void buildPaths() {
    // Path for scoring preload
    scorePreload = new Path(new BezierLine(new Point(startPose), new Point(scorePose)));
    scorePreload.setLinearHeadingInterpolation(startPose.getHeading(), scorePose.getHeading());

    // Path chains for picking up and scoring samples
    grabPickup1 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(pickup1Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), pickup1Pose.getHeading())
            .build();

    scorePickup1 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(pickup1Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(pickup1Pose.getHeading(), scorePose.getHeading())
            .build();

    grabPickup2 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(pickup2Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), pickup2Pose.getHeading())
            .build();

    scorePickup2 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(pickup2Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(pickup2Pose.getHeading(), scorePose.getHeading())
            .build();

    grabPickup3 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(pickup3Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), pickup3Pose.getHeading())
            .build();

    scorePickup3 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(pickup3Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(pickup3Pose.getHeading(), scorePose.getHeading())
            .build();

    // Curved path for parking
    park = new Path(new BezierCurve(new Point(scorePose), new Point(parkControlPose), new Point(parkPose)));
    park.setLinearHeadingInterpolation(scorePose.getHeading(), parkPose.getHeading());
}