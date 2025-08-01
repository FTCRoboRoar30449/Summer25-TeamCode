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

private final Pose startPose = new Pose(8, 80, Math.toRadians(0));  // Starting/idle position
private final Pose scorePose = new Pose(20, 120, Math.toRadians(-45)); // Scoring/high basket position

private final Pose preStaged1Pose = new Pose(30, 120, Math.toRadians(0)); // First Pre-staged sample pickup
private final Pose preStaged2Pose = new Pose(30, 130, Math.toRadians(0)); // Second Pre-staged sample pickup
private final Pose preStaged3Pose = new Pose(30, 130, Math.toRadians(45)); // Third Pre-staged sample pickup
private final Pose subPose = new Pose(71, 105, Math.toRadians(-90)); // sub pickup/position
private final Pose endPose = new Pose(70, 100, Math.toRadians(90));    // Endgame position - low rung

        private Path scorePreload, park;
        private PathChain grabPreStaged1, grabPreStaged2, grabPreStaged3, grabSub, scorePreStaged1, scorePreStaged2, scorePreStaged3, scoreSub;

public void buildPaths() {
    // Path for scoring preload
    scorePreload = new Path(new BezierLine(new Point(startPose), new Point(scorePose)));
    scorePreload.setLinearHeadingInterpolation(startPose.getHeading(), scorePose.getHeading());

    // Path chains for picking up and scoring samples
    grabPreStaged1 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(preStaged1Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), preStaged1Pose.getHeading())
            .build();

    scorePreStaged1 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(preStaged1Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(preStaged1Pose.getHeading(), scorePose.getHeading())
            .build();

    grabPreStaged2 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(preStaged2Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), preStaged2Pose.getHeading())
            .build();

    scorePreStaged2 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(preStaged2Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(preStaged2Pose.getHeading(), scorePose.getHeading())
            .build();

    grabPreStaged3 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(preStaged3Pose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), preStaged3Pose.getHeading())
            .build();

    scorePreStaged3 = follower.pathBuilder()
            .addPath(new BezierLine(new Point(preStaged3Pose), new Point(scorePose)))
            .setLinearHeadingInterpolation(preStaged3Pose.getHeading(), scorePose.getHeading())
            .build();

    grabSub = follower.pathBuilder()
            .addPath(new BezierLine(new Point(scorePose), new Point(subPose)))
            .setLinearHeadingInterpolation(scorePose.getHeading(), subPose.getHeading())
            .build();

    scoreSub = follower.pathBuilder()
            .addPath(new BezierLine(new Point(subPose), new Point(scorePose)))
            .setLinearHeadingInterpolation(subPose.getHeading(), scorePose.getHeading())
            .build();

    // The .pp file does not give us the heading of the control pose for a curved path, so we will not be needing this code.
    // Curved path for parking
    // park = new Path(new BezierCurve(new Point(scorePose), new Point(parkControlPose), new Point(parkPose)));
    // park.setLinearHeadingInterpolation(scorePose.getHeading(), parkPose.getHeading());
}

