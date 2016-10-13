SUMMARY = "A cross-platform library for capturing data from the RealSense F200, SR300 and R200 cameras"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libpng libusb1 libglu glfw"
RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-examples += "${PN}"
RDEPENDS_${PN}-graphical-examples += "${PN} libgl-mesa"

inherit pkgconfig

EXAMPLES_DIR = "${datadir}/${PN}/examples"

BACKEND ?= "V4L2"

EXTRA_OEMAKE = "\
    'BACKEND=${BACKEND}' \
    'CC=${CC}' \
    'CXX=${CXX}' \
    'CFLAGS=${CFLAGS} -std=c11 -fPIC -pedantic -DRS_USE_$(BACKEND)_BACKEND $(LIBUSB_FLAGS)' \
    'CXXFLAGS=${CXXFLAGS} -std=c++11 -fPIC -pedantic -mssse3 -O3 -Wno-missing-field-initializers -Wno-switch -Wno-multichar -DRS_USE_$(BACKEND)_BACKEND $(LIBUSB_FLAGS)' \
"

do_install() {
	install -d "${D}${EXAMPLES_DIR}"
	install -m 755 ${S}/bin/c-* ${D}${EXAMPLES_DIR}
	install -m 755 ${S}/bin/cpp-* ${D}${EXAMPLES_DIR}

	install -d "${D}${libdir}"
	oe_libinstall -C ${S}/lib/ -so ${PN} ${D}${libdir}

	install -d "${D}${includedir}/${PN}"
	install -m 0644 ${S}/include/${PN}/*.h ${D}${includedir}/${PN}
	install -m 0644 ${S}/include/${PN}/*.hpp ${D}${includedir}/${PN}

	install -d "${D}${sysconfdir}/udev/rules.d"
	install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d
}

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev ${PN}-examples ${PN}-graphical-examples"

FILES_${PN} = "${libdir}/* ${sysconfdir}/udev/rules.d/*"
FILES_${PN}-dev += "${includedir}/${PN}"
FILES_${PN}-dbg += "${EXAMPLES_DIR}/.debug"
FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/c-tutorial-1-depth \
	${EXAMPLES_DIR}/cpp-enumerate-devices \
	${EXAMPLES_DIR}/cpp-headless \
	${EXAMPLES_DIR}/cpp-tutorial-1-depth \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/c-tutorial-2-streams \
	${EXAMPLES_DIR}/c-tutorial-3-pointcloud \
	${EXAMPLES_DIR}/cpp-alignimages \
	${EXAMPLES_DIR}/cpp-capture \
	${EXAMPLES_DIR}/cpp-config-ui \
	${EXAMPLES_DIR}/cpp-multicam \
	${EXAMPLES_DIR}/cpp-pointcloud \
	${EXAMPLES_DIR}/cpp-restart \
	${EXAMPLES_DIR}/cpp-tutorial-2-streams \
	${EXAMPLES_DIR}/cpp-tutorial-3-pointcloud \
"

# Configuration is not required
do_configure[noexec] = "1"

INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN}-examples += "ldflags"
INSANE_SKIP_${PN}-graphical-examples += "ldflags"
