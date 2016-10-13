require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=master"
SRCREV = "74ff66da50210e6b9edc3157411bad95c209740f"

PR = "r0"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${bindir}/cpp-callback \
	${bindir}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${bindir}/cpp-callback-2 \
	${bindir}/cpp-stride \
"
