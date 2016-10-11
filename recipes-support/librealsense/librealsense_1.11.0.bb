require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=master"
SRCREV = "74ff66da50210e6b9edc3157411bad95c209740f"

PR = "r0"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
