SUMMARY = "A cross-platform library for capturing data from the RealSense F200, SR300 and R200 cameras"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libpng libusb1 libglu glfw"
RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-examples += "${PN}"
RDEPENDS_${PN}-graphical-examples += "${PN} libgl-mesa"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS:BOOL=ON -DBUILD_EXAMPLES:BOOL=ON -DBUILD_UNIT_TESTS:BOOL=OFF"

do_install_append() {
	install -d "${D}${sysconfdir}/udev/rules.d"
	install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d
}

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev ${PN}-examples ${PN}-graphical-examples"

FILES_${PN} = "${libdir}/* ${sysconfdir}/udev/rules.d/*"
FILES_${PN}-dev += "${includedir}/${PN}"
FILES_${PN}-dbg += "${bindir}/.debug"
FILES_${PN}-examples += "\
	${bindir}/c-tutorial-1-depth \
	${bindir}/cpp-enumerate-devices \
	${bindir}/cpp-headless \
	${bindir}/cpp-tutorial-1-depth \
"
FILES_${PN}-graphical-examples += "\
	${bindir}/c-tutorial-2-streams \
	${bindir}/c-tutorial-3-pointcloud \
	${bindir}/cpp-alignimages \
	${bindir}/cpp-capture \
	${bindir}/cpp-config-ui \
	${bindir}/cpp-multicam \
	${bindir}/cpp-pointcloud \
	${bindir}/cpp-restart \
	${bindir}/cpp-tutorial-2-streams \
	${bindir}/cpp-tutorial-3-pointcloud \
"
