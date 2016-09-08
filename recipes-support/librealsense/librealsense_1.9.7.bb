require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=master"
SRCREV = "22155fdd2a4f20c2736285a753ce8b1059031e10"

PR = "r1"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
