/**
 *  Java HTML Tidy - JTidy
 *  HTML parser and pretty printer
 *
 *  Copyright (c) 1998-2000 World Wide Web Consortium (Massachusetts
 *  Institute of Technology, Institut National de Recherche en
 *  Informatique et en Automatique, Keio University). All Rights
 *  Reserved.
 *
 *  Contributing Author(s):
 *
 *     Dave Raggett <dsr@w3.org>
 *     Andy Quick <ac.quick@sympatico.ca> (translation to Java)
 *     Gary L Peskin <garyp@firstech.com> (Java development)
 *     Sami Lempinen <sami@lempinen.net> (release management)
 *     Fabrizio Giustina <fgiust at users.sourceforge.net>
 *
 *  The contributing author(s) would like to thank all those who
 *  helped with testing, bug fixes, and patience.  This wouldn't
 *  have been possible without all of you.
 *
 *  COPYRIGHT NOTICE:
 * 
 *  This software and documentation is provided "as is," and
 *  the copyright holders and contributing author(s) make no
 *  representations or warranties, express or implied, including
 *  but not limited to, warranties of merchantability or fitness
 *  for any particular purpose or that the use of the software or
 *  documentation will not infringe any third party patents,
 *  copyrights, trademarks or other rights. 
 *
 *  The copyright holders and contributing author(s) will not be
 *  liable for any direct, indirect, special or consequential damages
 *  arising out of any use of the software or documentation, even if
 *  advised of the possibility of such damage.
 *
 *  Permission is hereby granted to use, copy, modify, and distribute
 *  this source code, or portions hereof, documentation and executables,
 *  for any purpose, without fee, subject to the following restrictions:
 *
 *  1. The origin of this source code must not be misrepresented.
 *  2. Altered versions must be plainly marked as such and must
 *     not be misrepresented as being the original source.
 *  3. This Copyright notice may not be removed or altered from any
 *     source or altered source distribution.
 * 
 *  The copyright holders and contributing author(s) specifically
 *  permit, without fee, and encourage the use of this source code
 *  as a component for supporting the Hypertext Markup Language in
 *  commercial products. If you use this source code in a product,
 *  acknowledgment is not required but would be appreciated.
 *
 */
package org.w3c.tidy;

/**
 * testcase for JTidy resolved bugs (Tidy warning and errors).
 * @author fgiust
 * @version $Revision$ ($Author$)
 */
public class JTidyWarningBugsTest extends TidyTestCase
{

    /**
     * Instantiate a new Test case.
     * @param name test name
     */
    public JTidyWarningBugsTest(String name)
    {
        super(name);
    }

    /**
     * test for JTidy [828316]: FRAMEBORDER attribute of IFRAME gives spurious warning.
     * @throws Exception any exception generated during the test
     */
    public void test828316() throws Exception
    {
        executeTidyTest("828316.html");
        assertNoWarnings();
        assertNoErrors();
    }

    /**
     * test for JTidy accepting <code>canvas</code> elements.
     * @throws Exception any exception generated during the test
     */
    public void testCanvas() throws Exception
    {
    	executeTidyTest("test-canvas.html");
    	assertNoWarnings();
    	assertNoErrors();
    }
    
    /**
     * test for JTidy [444834]: Silent Option.
     * @throws Exception any exception generated during the test
     */
    public void test444834() throws Exception
    {
        // only need to test the "quiet" option
        executeTidyTest("444834.html");
        assertEquals("errorLog should be empty, size doesn't match", 0, this.errorLog.toString().length());
    }

}