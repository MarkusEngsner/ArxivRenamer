import java.io.{File, FileInputStream, FileOutputStream}
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import java.nio.file.Files.copy
import java.nio.file.Paths.get

def copyFile(oldName: String, newName: String) = {
  def toPath(s: String) = get(s)

  copy(toPath(oldName), toPath(newName), REPLACE_EXISTING)
}

println(System.getProperty("user.dir"))
copyFile("test.txt", "new.txt")