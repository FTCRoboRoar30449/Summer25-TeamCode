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
// **dont get heading** //private final Pose subControlPose = new Pose(60, 98, Math.toRadians(90)); // Control point for curved path to sub position
private final Pose endPose = new Pose(72, 45, Math.toRadians(-90));    // Endgame position - low rung

